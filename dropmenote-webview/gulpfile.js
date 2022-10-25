/* File: gulpfile.js */
/* Commandline file */
var gulp = require('gulp');
var concat = require('gulp-concat');
var sourcemaps = require('gulp-sourcemaps');
var ngAnnotate = require('gulp-ng-annotate');
var uglifly = require('gulp-uglify');
var js_obfuscator = require('gulp-js-obfuscator');
var appRoot = "";

var jsFilesLocation = [
    "app/assets/js/angular.min.js"
    , "app/assets/js/angular-route.min.js"
    , "app/assets/js/angular-messages.min.js"
    , "app/assets/js/mobile-angular-ui.min.js"
    , "app/assets/js/mobile-angular-ui.gestures.min.js"
    , "app/assets/js/angular-cookies.js"
    , "app/assets/js/angular-animate.min.js"
    , "app/assets/js/angular-aria.min.js"
    , "app/assets/js/angular-material.min.js"
    , "app/assets/js/fingerprint.js"
    , "app/assets/js/scrollglue.js"

    , "app/app.js"
    , "app/main.js"

    , "app/service.js"
    , "app/toast.js"
    , "app/dialog.js"

    , "app/setting.js"
    , "app/saveqrcode.js"
    , "app/sidebar.js"
    , "app/guide.js"
    , "app/blacklist.js"
    , "app/qrcodelist.js"
    , "app/qrcodeshare.js"
    , "app/forgotpassword.js"
    , "app/chat.js"
    , "app/about.js"
    , "app/inbox.js"
    , "app/infoqrcode.js"

    , "app/d_login.js"
    , "app/d_registration.js"
    , "app/d_forgotpassword.js"
    , "app/d_editblacklist.js"
    , "app/d_editqrcodeshare.js"
    , "app/d_addqrcodeshare.js"
    , "app/d_inboxfilter.js"
    , "app/d_changepassword.js"
    , "app/d_installapp.js"
    , "app/d_chatblacklist.js"
    , "app/d_qrcodenotfound.js"
    , "app/d_forgotpasswordemailsend.js"
    , "app/d_logout.js"
    , "app/d_savedata.js"
    , "app/assets/js/textAngular-rangy.min.js"
    , "app/assets/js/textAngular-sanitize.min.js"
    , "app/assets/js/textAngular.min.js"
];

/*
 * ------- Tasks -------
 */
gulp.task('build-js', function () {
    return gulp.src(jsFilesLocation) //
        .pipe(ngAnnotate()) //
        .pipe(concat('starbug-dropmenote.min.js')) //
        // .pipe(uglifly()) //
        //.pipe(js_obfuscator({}, ['./starbug-dropmenote.min.js'])) //
        .pipe(gulp.dest('./')) //
});
gulp.task('default', ['build-js']);