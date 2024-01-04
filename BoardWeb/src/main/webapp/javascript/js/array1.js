// array1.js
// ary = []
const ary = [1, 2];

const numAry = [10, 20, 30, 40];
numAry.push(30); // 배열 끝에 추가
numAry.unshift(40); // 배열 처음에 추가
numAry.pop(); // 마지막 요소 삭제
numAry.shift(); // 첫 요소 삭제
// numAry.splice(1, 1, 50); // splice(시작위치, 지울 요소 갯수) / splice(교환희망 요소위치, 교환할 개수(0이면 1번값 위치에 3번째이후 값 추가함), 교환할 요소)

// length : 읽기 속성이 아니고 크기를 변경할 수 있음.
// numAry.length = 10; // 배열의 크기를 10으로 변경.
console.log(numAry.length);

const numAry2 = [50, 60];

// const numAry3 = numAry.concat(numAry2);
// numAry에 numAry2을 추가
numAry2.forEach(item => { numAry.push(item) });
console.log(numAry);
