app.controller("TutorialController", function ($rootScope, $scope, $location, $http, $cookies, dpnService, $mdDialog, dpnDialog, dpnToast) {

    $scope.$on('$routeChangeSuccess', function (event) {
        gtag('config', 'G-HW2X468HDZ', {
            'page_title': 'Tutorial',
            'page_path': $location.url()
        });
    });
    // ----------------
    // tries to login
    // ---------------
    $scope.deviceId = fingerprint_uuid;

    var call_user_loginByToken_callbackSuccess = function () {
        window.open("#/inbox", "_self");
    };
    var call_user_loginByToken_callbackError = function () {
        //DO NOTHING;
    };
    // call webservice
    dpnService.call_user_loginByToken($scope.deviceId, call_user_loginByToken_callbackSuccess, call_user_loginByToken_callbackError);

});