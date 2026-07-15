var variable = 10;
var r1;
var r2 = 20;
var r3;
(() => {
  console.log(variable);
  console.log(r1);
  variable = 20;
  console.log(variable);
})(); // iife
// immidieat involcked function expression.
console.log(variable);
var variable = 30;

// use debugger . if any variable is not using in the code . you cant see it in debugger;
