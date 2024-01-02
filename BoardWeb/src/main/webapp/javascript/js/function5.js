// function5.js

// Array.prototype.forEach();
const ary = ['a', 'b', 'c']
ary.forEach(elem => console.log(elem));

ary.forEach((elem, idx) => {
    if (idx > 0) {
        console.log(elem);
    }
})

Array.prototype.sum = function () { // prototype : 정의되어진 영역안에서만 사용가능
    console.log(this);
    let result = 0;
    this.forEach(val => result += val)
    return result;
}
const numbers = [1, 2, 3, 4];
console.log('sum: ' + numbers.sum());