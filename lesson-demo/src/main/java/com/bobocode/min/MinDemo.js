function findMin(elements) {
    let min = elements[0];
    for (let element of elements) {
        if (Number.parseInt(min) > Number.parseInt(element)) {
            min = element;
        }
    }
    return min;
}

let min = findMin([6, 3, 4, 6, 79, 123, 3453, 7667, 5, 4, 67]);
console.log(min);