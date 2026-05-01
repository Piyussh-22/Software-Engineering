variable = 10;
(() => {
  foo = 100;
  console.log(variable);
  var foo = 100;
  variable = 20;
  console.log(variable);
})();
console.log(foo);
console.log(variable);
var variable = 30;

/* here inside the code phase the funtion run and that fun has two phase memroty and code and foo is defined insde that fn as that fn ends there is no foo */
