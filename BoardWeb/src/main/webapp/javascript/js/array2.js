// array2.js
const numAry = [23, 10, 17, 35, 9];

let result = numAry.reduce((acc, num) => {
    // console.log(acc, num);
    // acc += num;
    return acc + num;
}, 0);

result = numAry.reduce((acc, num) => {
    return acc > num ? acc : num;
}, 0);

// 1. 최소값, 2. 평균 구하기.
result = numAry.reduce((acc, num) => {
    return acc < num ? acc : num;
}, 23);
console.log(`결과: ${result}`);

result = numAry.reduce((acc, num) => {
    return acc + num;
}, 0) / numAry.length;
console.log(`결과: ${result}`);

result = numAry.reduce((acc, num, idx) => {
    return idx == numAry.length - 1 ? (acc + num) / numAry.length : acc + num;
}, 0);
console.log(`결과: ${result}`);

// 10보다 큰 값을 새로운 배열
result = numAry.reduce((acc, num) => {
    if (num > 10) {
        acc.push(num);
    }
    return acc;
}, []);
console.log(`결과: ${result}`);
