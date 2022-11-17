app.controller("DLoginController", function ($rootScope, $scope, $http, $cookies, $timeout, dpnService, $mdDialog, dpnDialog, dpnToast, paramLogin, paramPassword) {

    // ----------------
    // load data
    // ---------------
    $scope.login = {
        login: '',
        password: '',
        deviceId: ''
    }

    // check if app.js deviceId
    if (deviceId) {
        $scope.login.deviceId = deviceId;
    }
    if (paramLogin != undefined && paramLogin != null) {
        $scope.login.login = paramLogin;
    }
    if (paramPassword != undefined && paramPassword != null) {
        $scope.login.password = paramPassword;
    }
    if (!$scope.login.deviceId || $scope.login.deviceId == 'undefined' || $scope.login.deviceId == 'null') {
        $scope.login.deviceId = fingerprint_uuid;
        deviceId = fingerprint_uuid;
    }
    

    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    $scope.click_login_submit = function (requestData) {

        // callbacks
        var call_login_submit_callbackSuccess = function () {
            $scope.closeDialog();
            $rootScope.$broadcast('login.timestamp.value', Date.now());
            // window.open('#/qrcodelist', "_self");  
            // location.hash = '';
        };
        var call_login_submit_callbackError = function () {
            dpnToast.showToast("ERROR", "Login", "Login failed");
        };

        if ($scope.login.login != "" && checkIfEmailInString($scope.login.login)) {
            // call webservice
            dpnService.call_user_login(requestData, call_login_submit_callbackSuccess, call_login_submit_callbackError);
        }
    }

    // open forgotpassword dialog
    $scope.click_forgotpassword_submit = function(login) {
        $mdDialog.hide();
        dpnDialog.showForgotPasswordEmailSend(login.login);
    }
    
    // open registration dialog
    $scope.click_register_submit = function() {
        $mdDialog.hide();
        dpnDialog.showRegistration();
    }
});