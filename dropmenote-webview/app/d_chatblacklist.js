app.controller("DChatBlacklistController", function ($rootScope, $scope, $mdDialog, param_parent, param_blacklist, dpnDialog) {

    // init data
    $scope.blacklist = param_blacklist;

    //-------------------------
    // Click events
    //-------------------------

    // hide dialog
    $scope.closeDialog = function () {
        $mdDialog.hide();
    }

    // otvori edit blacklist dialog s predvyplnenymi udajmi o userovi
    $scope.click_on_user = function(blacklistObj) {
        $mdDialog.hide();
        dpnDialog.showEditBlacklist(param_parent, blacklistObj);
    }
});