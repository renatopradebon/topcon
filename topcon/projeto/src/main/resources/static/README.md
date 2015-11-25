## (I) Instalando os módulos

Essa parte é a mais fácil. Baseada nas tarefas que você gostaria de automatizar, será necessário instalar os módulos do Gulp. No nosso exemplo, faremos um procedimento simples, de minificação de arquivos em JavaScript utilizando o Uglify. Então além dos módulos que farão o gulp funcionar (gulp e gulp-util), você precisará instalar o módulo da minificação (gulp-uglify) e de quebra instalaremos também um módulo para monitorar alterações nos arquivos .js e rodará a tarefa da minificação (gulp-watch)

```js
$ npm install gulp --save-dev
$ npm install gulp-util --save-dev
$ npm install gulp-uglify --save-dev
$ npm install gulp-watch --save-dev
```

Note que para cada módulo instalado, utilizamos o parâmetro –save-dev. Isto modificará nosso arquivo package.json adicionando ao mesmo os módulos que a partir de agora são dependências para rodarmos as tarefas do Gulp. Se você for curioso, pode expiar o conteúdo do package.json, ele deve estar assim:

```js
{
  "name": "gulpteste",
  "version": "0.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "devDependencies": {
    "gulp": "~3.3.0",
    "gulp-util": "~2.2.9",
    "gulp-uglify": "~0.1.0",
    "gulp-watch": "~0.3.3"
  }
}
```

A grande vantagem de instalar os módulos desta maneira, é a fácil reinstalação de todas as dependências. Imagine que inadvertidamente alguém apagou a pasta node_modules do seu projeto. Ou mesmo, imagine que você gostaria de compartilhar este projeto com outro desenvolvedor. Não há a mínima necessidade de versionar a pasta node_modules. Basta ter o package.json atualizado e uma única instrução fará que com que tudo volte ao normal. A título de teste, exclua agora sua pasta node_modules… da até uma tristeza né, afinal você terá que reinstalar tudo novamente. A boa notícia é que agora tudo será bem mais facil, bastando rodar um:

```js
$ npm install
```

Pronto! Tudo voltou a ordem que estava anteriormente.

## (II) Configurando suas tarefas

Para rodar o Gulp.js, você vai precisar configurar as tarefas que serão executadas. A título de exemplo, vamos criar 2 pastas, uma chamada src e outra chamada build, na raiz do projeto.

Dentro da pasta src, vamos criar uma pasta js onde ficarão todos os arquivos originais de desenvolvimento.

Com a automatização, será criada automaticamente uma pasta js dentro de build, com os arquivos js que estão na pasta src, porém estes últimos estarão minificados pelo Uglify. Para essa mágica toda acontecer, vamos criar na raiz o arquivo de configuração das tarefas, o gulpfile.js.

Abra o arquivo e mãos a obra. O primeiro passo é instanciar os módulos que vamos utilizar:

```js
// instanciando módulos
var gulp = require('gulp');
var gutil = require('gulp-util');
var uglify = require('gulp-uglify');
var watch = require('gulp-watch');
```

A primeira tarefa que vamos definir, é que vai minificar os arquivos da pasta src/js para pasta build/js. Para isto, utilizaremos o método gulp.task(), que recebe 2 parâmetros. O primeiro é o nome da nova tarefa e o segundo uma função callback com os steps que devem ser executados a partir desta:

```js
gulp.task('scripts', function() {
    // corpo da tarefa
});
```

## (III) Para configurar a minificação, precisamos definir 3 ações:

1 – recuperar os arquivos fonte na pasta de origem;
2 – aplicar a minificação (uglify);
3 – colocar o resultado na pasta de destino.

O código ficará assim:

```js

gulp.task('scripts', function() {
    // corpo da tarefa 
    return gulp
            .src(['src/js/**/*.js'])
            .pipe(uglify())
            .pipe(gulp.dest('build/js'));      
});

```

Pronto! Para rodá-la, podemos ir ao terminal e digitar:

```js
$ gulp scripts
```
E conferir se os arquivos foram minificados em build/js.

Para deixar a coisa mais legal, vamos configurar a tarefa que vai monitorar alterações na pasta src/js e rodar a tarefa ‘scripts’, responsável pela minificação. Começamos da mesma forma:

```js
gulp.task('watch', function() {
   // corpo da tarefa 
});
```

Dentro da nova task, vamos utilizar o método gulp.watch() que recebe 2 parâmetros. No primeiro, definimos a pasta onde estão os nossos arquivos fonte e um função callback que será executada toda vez que um desses arquivos for modificado:

```js
gulp.task('watch', function() {
    // corpo da tarefa 
    gulp.watch('src/js/**/*.js', function(event) {});
});
```

Agora no callback, o método gutil.log() exibirá informações do arquivo alterado, e através do método gulp.run() definimos qual tarefa será executada. Isso acontecerá toda vez que um arquivo presente em src/js for alterado:

```js
gulp.task('watch', function() {
    // corpo da tarefa 
    gulp.watch('src/js/**/*.js', function(event) {
        gutil.log('File '+event.path+' was '+event.type+', running tasks...');
        gulp.run('scripts');
    });
});
```

Vamos conferir, no terminal execute:

```js
$ gulp watch
```

Ai basta alterar qualquer arquivo .js da pasta fonte e ver o resultado na pasta build/js.

> http://blog.caelum.com.br/bye-bye-grunt-js-hello-gulp-js/
