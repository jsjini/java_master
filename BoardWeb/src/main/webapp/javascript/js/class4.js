// class4.js

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{ name: '야옹이', gender: 'M', friends: ['검양이', '빨양이'] }, { name: '멍멍이', gender: 'F' }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
friend.pets[0]['friends'][2] = '노량이';
delete friend.age; // 속성을 지울땐 delete
friend.ages = 20; // 속성추가
friend.showFriends = function () { // 속성추가
    console.log(this);
}
console.log(friend);
console.log(friend.pets[0]['friends']);

// 참조값을 복사
const fcopy = friend;  // 주소값을 복사.
fcopy.age = 22; // 값을 변경하면 원본값도 같이 변함.
console.log(fcopy);

// 객체를 복사
const fcopy2 = Object.assign({ bloodType: 'O' }, friend);  // assign : 새로운 객체를 생성
fcopy2.age = 24; // 값을 변경해도 원본값은 유지됨.
console.log(fcopy2);

// 속성추가 : defineProperty()
Object.defineProperty(friend, 'height', {
    get: function () {
        return this._height;
    },
    set: function (value) {
        if (value <= 0) {
            alert('error');
        } else {
            this._height = value; // _ : 숨김속성 / 이름이 같을때 사용하면됨.
        }
    }
});
friend.height = 162;
console.log(friend.height);