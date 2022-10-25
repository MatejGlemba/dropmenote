app.controller("DQrCodeNotFoundController", function ($rootScope, $timeout, $scope, dpnService, dpnDialog, $mdDialog) {

    // ------------
    // Click events
    // ------------
    $scope.token = dpnService.getCookieTokenObject().token;

    $scope.closeDialog = function () {
        $mdDialog.hide();
        if ($scope.token) {
            window.open("#/qrcodelist", "_self");
        } else {
            dpnDialog.showInstallApp($scope);
        } 
        dpnService.revalidateLogoutCover();
    }
});