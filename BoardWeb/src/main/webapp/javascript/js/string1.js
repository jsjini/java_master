// string1.js

let str1 = "Hello";
console.log(str1, typeof str1);
let str2 = new String("Hello");
console.log(str2, typeof str2);

console.log(str1 == str2);
console.log(str1 === str2);
console.log(str2.substring(1, 3));

// let word = "   Hello, World  ";
console.log(word.trim()); // trim => 좌우 공백 제거 trimStart => 좌 공백 제거 trimEnd => 우 공백 제거
//  const obj = new Object(); {}
//  const reg = new RegExp(); /값/
console.log(word.replace(/l/g, 'L')); // replace => 값 변경 , /?/g => 문장 내 ? 전체를 바꿔줌
console.log(word.replace(/\s/g, '')); // \s => 공백을 의미

word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter(val => val).join(' '));


