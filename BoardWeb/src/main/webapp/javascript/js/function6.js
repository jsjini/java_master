// function6.js
const args = [4, 5, 6];

function sum(num1 = 0, num2 = 0, ...args) {
    let result = 0;
    result = num1 + num2;
    if (args.length > 0) {
        args.forEach(val => {
            result += val;
        });
    }
    return result;
}

console.log(sum(10, 20, ...args)); // ... : 펼침연산자 - 배열의 요소들을 펼쳐줌 - 파라메터로 사용할 경우 마지막에 사용해야함.

const ary1 = [10, 20];

const ary2 = ary1.concat(args); // concat : 배열을 연결해줌
console.log(ary2);

const ary3 = [...ary1, ...args];
console.log(ary3);

const obj1 = { name: "Hong", age: 20 };
const obj2 = { name: "Hwang", height: 170 };

const obj3 = { ...obj1, ...obj2 }; // 같은 속성은 덮어쓰고 다른 속성은 추가된다.
console.log(obj3);

// reduce 메소드
let result = [4, 5, 6].reduce((acc, curItem, idx, ary) => { // reduce(누산값, 현재값, 인덱스, 배열);
    console.log(acc, curItem, idx);
    return acc + curItem;
}, 0);
console.log('결과값: ' + result);

// map 메소드
result = [1, 2, 3, 4].map((item, idx, ary) => {
    console.log(item, idx, ary);
    return item * 2;
});
console.log('결과값: ', result);

// 변수의 스코프(영역)
var name = '어피치';
var name = '어피치'; // var는 중복된 변수도 사용가능. let은 불가능. let 사용권장.
console.log(window);
function run() {
    if (true) {
        // let name = '라이언'; // let은 블록안에서만 사용가능 / 함수안에 var는 함수안에서 사용가능
        var name = '라이언';
    }
    console.log(name);
    return name;
}
run();
console.log(name);

// 스코프 체인
var a = 1;
var b = 5;

function outerFunc() {
    // var b; undefined
    function innerFunc() { // 내부함수는 함수안에서만 사용가능.
        a = b;
    }
    console.log(a); // 1
    a = 3;
    b = 4;
    innerFunc();
    console.log(a, b); // 4, 4
    var b = 2; // 호이스팅 - 함수의 첫부분으로 undefined값으로 끌어올림 
    console.log(b); // 2
}
outerFunc();


// 예외처리
const c = 10;
try {
    c = 20;
} catch (error) {
    console.log(error);
} finally {
    console.log(c);
}
