// instanciando módulos
// $ npm install --save-dev gulp
// $ npm install --save-dev gulp-cssmin
// $ npm install --save-dev gulp-util
// $ npm install --save-dev gulp-ugligy
// $ npm install --save-dev gulp-cssmin 
// $ npm install --save-dev gulp-watch 
// $ npm install --save-dev gulp-concat 
// $ npm install --save-dev gulp-strip-css-comments

var js = [
      	"assets/js/jquery.js",
    	"assets/js/angular.min.js",
    	"assets/js/angular-animate.js",
        "assets/js/amgular-chart.js"
        "assets/js/amgular-ui-router.js"
        "assets/js/ui-bootstrap-tpls-0.14.3.js"
        "assets/js/bootstrap.min.js"
        "assets/js/chart.js"
        ];

//
var gulp = require('gulp');

//Remove comentários CSS
var stripCssComments = require('gulp-strip-css-comments');

//
var gutil = require('gulp-util');

//Transforma o javascript em formato ilegível para humanos
var uglify = require('gulp-uglify');

//
var watch = require('gulp-watch');

//Minifica o CSS
var cssmin = require("gulp-cssmin");

//Agrupa todos os arquivos em um
var concat = require("gulp-concat");

//tarefas

gulp.task('build-js', function() {
    return gulp
            .src(js)
            .pipe(uglify())
            .pipe(gulp.dest('build/js'));      
});

gulp.task('build-css', function(){
    gulp.src(['assets/css/*.css'])
    .pipe(stripCssComments({all: true}))
    .pipe(cssmin())
    .pipe(gulp.dest('build/css/'));
});


//Tarefa de minificação do Javascript
gulp.task('concat-js', function () {
    gulp.src(js)            // Arquivos que serão carregados, veja variável 'js' no início
    .pipe(concat('app.min.js'))      // Arquivo único de saída
    .pipe(uglify())                  // Transforma para formato ilegível
    .pipe(gulp.dest('build/'));       // pasta de destino do arquivo(s)
});

 

//Cria a TASK de verificar em tempo real alterações, 
//se detectar alguma alteração, será processado o comando relativo ao arquivo
gulp.task('watch-css', function() {
	gulp.watch(['assets/css/*.css'], ['minify-css']);
});
