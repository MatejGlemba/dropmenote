app.controller("DForgotPasswordController", function ($rootScope, $scope, $http, $cookies, $mdDialog, dpnService, dpnToast,$mdToast, paramEmail, paramEmailRecoveryToken, dpnDialog) {

    // init data
    $scope.password = '';
    $scope.repeatpassword = '';
    $scope.passwordChanged = false;

    //-------------------------
    // Click events
    //-------------------------

    // reset password for user
    $scope.submitPassword = function() {
        if (!$scope.password) {
            dpnToast.showToast("ERROR", "Empty password", "Fill in password");
            return;
        }
        if ($scope.password != $scope.repeatpassword) {
            dpnToast.showToast("ERROR", "Password mismatch", "Password and repeated password are not the same!");
            return;
        }
        if ($scope.password && $scope.repeatpassword && $scope.password == $scope.repeatpassword) {
            var call_user_updatePswdRecovery_successCallback = function(data) {
                $mdDialog.hide();
                $scope.passwordChanged = true;
                dpnToast.showToast("INFO", "Password changed", "Password successfully changed");
            }
            var call_user_updatePswdRecovery_errorCallback = function(data) {
                $mdDialog.hide();
                $scope.passwordChanged = false;                
                dpnToast.showToast("ERROR", "Password error", "Password was not changed!");
            }
            dpnService.call_user_updatePswdRecovery(paramEmailRecoveryToken, $scope.password, call_user_updatePswdRecovery_successCallback, call_user_updatePswdRecovery_errorCallback);
        }
    }
});