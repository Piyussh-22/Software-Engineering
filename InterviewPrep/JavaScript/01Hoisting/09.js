const piyush = {
  name: "Piyush Raj",
  sayName: function () {
    console.log(this.name);
  },
};
setTimeout(piyush.sayName, 3 * 1000);

setTimeout(piyush.sayName.bind(piyush), 3 * 1000);

//.bind return a function.
const newFun = piyush.sayName.bind(piyush);
setTimeout(newFun, 3 * 1000);

//clourse fn
setTimeout(() => piyush.sayName(), 3 * 1000);
