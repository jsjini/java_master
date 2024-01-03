// class3.js
class Estimate {
    constructor(param) {
        this.unit = param;
    }
    //견적가 얻기 메서드
    getEstimate(unittype, width, height) {
        let priceinfo = this.unit.find(item => item.type == unittype);
        return priceinfo.price * width * height;
    }
    // 배열에 요소 추가 메서드
    addUnit(unit) {
        this.unit.push(unit);
    }
}
let unitinfo = [{ type: "wood", price: 100 }, { type: "iron", price: 300 }, { type: "plastic", price: 200 }];
const estimator = new Estimate(unitinfo);
let unitinfo1 = estimator.addUnit({ type: "ccc", price: 400 });
let result = estimator.getEstimate('ccc', 20, 20);
console.log(result);
console.log(estimator);



const ary = []
ary.push(1);
ary.push(2);
ary.push(3);
console.log(ary);
console.log(ary.find(item => { // find  첫번째 값을 반환.
    return item >= 2; // true값을 첫번째 반환
}))

// 1. 객체: this는 객체자신
// 2. function(): this는 전역객체(window)
function myFunc() {
    console.log(this);
}
myFunc();

let obj = {}
obj.act = function () {
    this.value = 'default value';

    function innerAct() {
        this.value = 'innerAct value';
        console.log("this.value: " + this.value);
    }

    function innerReact(caller) {
        caller.value = "innerReact value";
        console.log("this.value: " + this.value);
        console.log("caller.value: " + caller.value);
    }
    innerAct();
    console.log("obj 객체의 this.value: " + this.value);

    innerReact(this);
    console.log("obj 객체의 this.value: " + this.value);
}
obj.act();

// window.location.href = "https://www.daum.net"

// 클로저
function outerFunc(name) {
    let saying = name + ' 안녕!';

    return function () {
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1());
console.log(closure2());

function getCounter() {
    let cnt = 1;

    return function () {
        cnt++;
        console.log(cnt);
    }
    // increaseCounter();
}
const clo1 = getCounter();
clo1();
clo1();
clo1();
clo1();
