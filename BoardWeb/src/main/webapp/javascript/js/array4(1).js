// array4.js
// map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// 1. 콘이라는 이름이 몇번?
console.log(str.split(', ').filter(item => item == '콘').length);
// 2. 이름이 3자 이상이 몇명?
console.log(str.split(', ').filter(item => item.length >= 3).length);
// 3. 2자인 이름이 있는지 여부?
console.log(str.split(', ').some(item => item.length == 2));
// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입.
const strAry = [];
str.split(', ').map((item, idx) => {
    let obj = {}
    obj.no = idx + 1;
    obj.name = item;
    return strAry.push(obj);
});

console.log(strAry);

console.log(strAry.filter(item => item.name == '콘').length);
console.log('콘: ', strAry.reduce((acc, obj) => {
    
}));

console.log(strAry.filter(item => item.name.length >= 3).length);
console.log(strAry.some(item => item.name.length == 2));
