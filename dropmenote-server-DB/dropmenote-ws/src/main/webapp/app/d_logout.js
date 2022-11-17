app.controller("DLogoutController", function ($rootScope, $scope, $mdDialog, dpnService, dpnToast, dpnDialog) {

    //-------------------------
    // Click events
    //-------------------------

    // hide dialog
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    // logout
    $scope.logout = function() {
        // remove inbox list data from storage;
        localStorage.setItem('matrixList', []);
        localStorage.setItem('qrcodelist', []);
        localStorage.setItem('user', null);

        //callbacks
        var call_user_logout_callBackSuccess = function (data) {
            dpnDialog.showLogin();
            dpnToast.showToast("INFO", "Logout", "You have logged out successfully.");
        }
        var call_user_logout_callBackError = function (data) {
            dpnService.processErrorResponse(data);
        }
        dpnService.call_user_logout(deviceId, call_user_logout_callBackSuccess, call_user_logout_callBackError);
    }
});