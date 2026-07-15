const piyush = {
  name: "piyush raj",
  sayName: function () {
    console.log(this.name);
  },
};
const anshu = {
  name: "anshu raj",
  sayName: function () {
    console.log(this.name);
  },
};
anshu.sayName();
anshu.sayName.call(piyush);

//explation
function sayMyName() {
  console.log(this.name);
}
sayMyName(); // undefined beacuse that this has no context but if it do call(piyush) or call(anshu) it will pick up the context of that function

sayMyName.call(piyush);
sayMyName.call(anshu);
