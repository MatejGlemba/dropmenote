app.controller("DInstallAppController", function ($rootScope, $scope, $mdDialog, dpnService) {

    $scope.isHidden = true; //TODO
    // ------------
    // Click events
    // ------------
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

});