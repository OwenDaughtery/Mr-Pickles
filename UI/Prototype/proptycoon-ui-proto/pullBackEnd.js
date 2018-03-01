var fs = require("fs");
var rimraf = require("rimraf");
var ncp = require("ncp");

var error = false;

function clean() {
    //Remove back-end 'ui' folder.
    rimraf('./src/BackEnd', function (err) {
        if (err) { error = true; throw err; }
        copy();
    });
}

function copy() {
    //Copy build folder to back-end 'ui' folder.
    ncp('../../../BackEnd/Prototype/proptycoon-backend-proto/src',
        './src/BackEnd', function (err) {
        if (err) { error = true; throw err; }
        onComplete();
    });
}

function onComplete() {
    if (!error)
        console.log("Successfully copied back-end source classes to UI source.");
    else 
        console.log("Could not copy back-end source classes.");
}

//Cleans, then copies, then outputs.
clean();