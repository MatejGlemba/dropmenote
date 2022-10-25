app.controller("DRegistrationController", function ($rootScope, $scope, dpnDialog, dpnService, dpnToast) {

    // init data
    $scope.registration = {
        login: '',
        password: '',
        repeatpassword: '',
        deviceId: ''
    };

    if (deviceId) {
        $scope.registration.deviceId = deviceId;
    }

    //-------------------------
    // Click events
    //-------------------------
    $scope.click_registration_submit = function (registration, form) {

        // callbacks
        var click_registration_submit_callbackSuccess = function () {
            $scope.click_backToLogin();
            dpnToast.showToast("INFO", "Registration", "Registration was successfull.");
        };
        var click_registration_submit_callbackError = function (data) {
            dpnService.processErrorResponse(data);
        };

        repeatpasswordValidate(form);
        if (registration.login && checkIfEmailInString(registration.login)) {
            if ((registration.password == registration.repeatpassword) && registration.password != "") {

                var registration_request = {
                    login: registration.login,
                    password: registration.password,
                    deviceId: registration.deviceId
                }
                // call webservice
                dpnService.call_user_register(registration_request, click_registration_submit_callbackSuccess, click_registration_submit_callbackError);
            } else {
                dpnToast.showToast("ERROR", "Password error", "Passwords are not the same.");
            }
        } else {
            dpnToast.showToast("ERROR", "Missing email!", "Fill up email field.")
        }
    }

    // check if passwords are same, otherwise display error-msg
    var repeatpasswordValidate = function (form) {
        if ($scope.registration.password != $scope.registration.repeatpassword) {
            form.registration_repeatpassword.$setValidity('passwordMismatch', false);
        } else {
            form.registration_repeatpassword.$setValidity('passwordMismatch', true);
        }
    };

    // open registration dialog
    $scope.click_backToLogin = function() {
        dpnDialog.showLogin();
    }
});