package io.dpm.dropmenote.ws.utils.email;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class EmailData {

    public static final String EMAIL_TYPE = "text/html; charset=utf-8";

    private String sendTo;
    private String subject;
    private String emailType;
    private String body;
    private String bcc;

    private List<Attachement> attachements = new ArrayList<>();

    /**
     * Default email type text/html; charset=utf-8
     */
    public EmailData() {
        this.emailType = EMAIL_TYPE;
    }

    /**
     * 
     * @param sendTo
     * @param subject
     * @param emailType
     * @param body
     * @param bcc
     * @param attachements
     */
    public EmailData(String sendTo, String subject, String emailType, String body, String bcc, List<Attachement> attachements) {
        super();
        this.sendTo = sendTo;
        this.subject = subject;
        this.emailType = emailType;
        this.body = body;
        this.bcc = bcc;
        this.attachements = attachements;
    }

    public List<Attachement> getAttachements() {
        return attachements;
    }

    public void setAttachements(List<Attachement> attachements) {
        this.attachements = attachements;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 
     * @author martinjurek
     *
     */
    public static class Attachement {

        private String name;
        private byte[] content;

        /**
         * 
         * @param name
         * @param content
         */
        public Attachement(String name, byte[] content) {
            this.name = name;
            this.content = content;
        }

        public byte[] getContent() {
            return content;
        }

        public void setContent(byte[] content) {
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Attachement [name=" + name + ", content=REMOVED_ITEM]";
        }

    }

    @Override
    public String toString() {
        return "EmailData [sendTo=" + sendTo + ", subject=" + subject + ", emailType=" + emailType + ", body=" + body + ", attachements=" + attachements + "]";
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

}
