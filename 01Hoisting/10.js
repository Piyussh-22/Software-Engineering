const obj = {
  height: 6,
};
/*
const obj =Object.create({
  height: 6,
});
*/
//Object.create save inside prototype
// so delete will not work
console.log(obj.height);
delete obj.height;
console.log(obj.height);
