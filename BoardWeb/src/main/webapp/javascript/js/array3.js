// array3.js
import {
    members,
    titles
} from './data.js';

console.log(members);
console.log(titles);

let str = titles.reduce((acc, title, idx) => {
    if (idx == 0) {
        acc += '<tr>';
    }
    acc += '<th>' + title + '</th>';
    if (idx == titles.length - 1) {
        acc += '</tr>';
    }
    return acc;
}, '');
console.log(str);
document.getElementById('theader').innerHTML = str; // <tr><th>...</th></tr>

const tbody = document.getElementById('tbody');
members.reduce((acc, member) => {
    let tr = document.createElement('tr');
    for (let prop in member) {
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);


// map(A -> A'), filter(A -> B)
let result = members.map((item, idx) => {
    let obj = {}
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
});

result = members // 메소드 체인
    .filter(item => item.gender == 'Female')
    .map((item, idx) => {
        let obj = {}
        obj.id = item.id;
        obj.name = item.first_name + '-' + item.last_name;
        obj.email = item.email;
        return obj;
    })
    .map(item => item.name);
result.push('charles');
result.push('Hong');
result.push('charles');

console.log(result.indexOf('charles', 6));


