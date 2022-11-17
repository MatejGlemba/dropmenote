app.controller("GuideController", function ($rootScope, $location, $scope, $cookies, $http, dpnDialog, dpnService) {
    $scope.$on('$routeChangeSuccess', function (event) {
        gtag('config', 'G-HW2X468HDZ', {
            'page_title': 'Guide',
            'page_path': $location.url()
        });
    });
});
