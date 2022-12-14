package io.dpm.dropmenote.ws.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;

import io.dpm.dropmenote.ws.services.helpers.StringHelper;
import io.dpm.matrix.api.MatrixID;
import io.dpm.matrix.client.MatrixPasswordCredentials;
import io.dpm.matrix.client.api.MatrixClient;
import io.dpm.matrix.client.regular.MatrixHttpClient;
import io.dpm.matrix.hs.api.MatrixRoom;
import io.dpm.matrix.room.api.RoomCreationOptions;
import java8.util.Optional;

/**
 * Pomaha pracovat s Matrix protokolom a Kamax SDK
 * 
 * @author Husarik (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class MatrixUtil {
	
	public static String generateMatrixPassword() {
		return StringHelper.randomString(10, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz,.;!@#$%^&*()_-+~<>?[]{}");
	}
	
	public static String generateMatrixUsername() {
		// Matrix User ID can only contain characters a-z, 0-9, or '=_-./' 
		return StringHelper.randomString(4, "0123456789")+StringHelper.randomString(16, "abcdefghijklmnopqrstuvwxyz0123456789=_-./");
	}

	/**
	 * Vytvorit Matrix usera 
	 * @param host bez uvodnej https:// casti
	 * @param username
	 * @param password
	 * @return klient objekt
	 * @throws Exception
	 */
	public static MatrixClient register(String host, String username, String password) throws Exception {
		URL url;
		try {
			url = new URL("https://" + host);
		} catch (MalformedURLException e) {
			throw new Exception(e);
		}
		MatrixClient client = new MatrixHttpClient(url);
		MatrixPasswordCredentials credentials = new MatrixPasswordCredentials(username, password);
		client.register(credentials , "", false);

		return client;
	}
	/**
	 * Vytvorit Matrix klienta pripojit na server 
	 * @param host bez uvodnej https:// casti
	 * @param username
	 * @param password
	 * @return klient objekt
	 * @throws Exception
	 */
	public static MatrixClient login(String host, String username, String password) throws Exception {
		URL url;
		try {
			url = new URL("https://" + host);
		} catch (MalformedURLException e) {
			throw new Exception(e);
		}
		MatrixClient client = new MatrixHttpClient(url);
		client.login(new MatrixPasswordCredentials(username, password));

		return client;
	}
	
	/**
	 * Klient vytavara roomu a automaticky do nej pozyva adminov
	 * 
	 * @param client
	 * @param invitesSet zoznam adminov v konverzacii
	 * @return
	 */
	public static MatrixRoom createRoom(MatrixClient client, Set<MatrixID> invitesSet) {
		Optional<String> name = Optional.empty();
		Optional<String> aliasName = Optional.empty();
		Optional<String> topic = Optional.empty();
		Boolean guestCanJoin = false;
		Optional<Set<MatrixID>> invites = invitesSet == null?Optional.empty():Optional.of(invitesSet);
		RoomCreationOptions options = new RoomCreationOptions() {
			
			@Override
			public Optional<Boolean> isGuestCanJoin() {
				return Optional.of(guestCanJoin);
			}
			
			@Override
			public Optional<Boolean> isDirect() {
				return Optional.of(true);
			}
			
			@Override
			public Optional<String> getVisibility() {
				return Optional.of("private");
			}
			
			@Override
			public Optional<String> getTopic() {
				return topic;
			}
			
			@Override
			public Optional<String> getPreset() {
				return Optional.empty();
			}
			
			@Override
			public Optional<String> getName() {
				return name;
			}
			
			@Override
			public Optional<Set<MatrixID>> getInvites() {
				return invites;
			}
			
			@Override
			public Optional<Map<String, JsonElement>> getCreationContent() {
				return Optional.empty();
			}
			
			@Override
			public Optional<String> getAliasName() {
				return aliasName;
			}
		};
		return client.createRoom(options);
	}
	
	
	public static MatrixID getMatrixIdObject(String username, String server) {
		MatrixID user = new MatrixID() {
			
			@Override
			public boolean isValid() {
				return getLocalPart() != null && !getLocalPart().isEmpty() && getDomain() != null && !getDomain().isEmpty();
			}
			
			@Override
			public boolean isAcceptable() {
				return true;
			}
			
			@Override
			public String getLocalPart() {
				return username;
			}
			
			@Override
			public String getId() {
				return "@"+getLocalPart()+":"+getDomain();
			}
			
			@Override
			public String getDomain() {
				return server;
			}
			
			@Override
			public MatrixID canonicalize() {
				if(isValid()) {
					return this;
				}else {
					return null;
				}
			}
		};
		
		return user;
	}
}