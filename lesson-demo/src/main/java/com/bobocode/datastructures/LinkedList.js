let head = null;

function createNode(element) {
    return {
        value: element,
        next: null
    }
}

function createLinkedList(elements) {
    if (head == null) {
        head = createNode(elements[0])
    }
    let current = head;
    for (let i = 1; i < elements.length; i++) {
        let newNode = createNode(elements[i]);
        current.next = newNode;
        current = newNode;
    }
}

function printLinkedList(head) {
    let current = head;
    let result = "";
    while (current.next != null) {
        result += `${current.value} -> `;
        current = current.next;
    }
    result += current.value;
    console.log(result);
}

function reverseLinkedList(head) {
    let current = head.next;
    let prev = head;
    let newCurrent;
    while (current != null) {
        newCurrent = current.next;

        current.next = prev;
        prev = current;
        current = newCurrent;
    }
    head.next = null;

    return prev;
}

createLinkedList([1, 2, 3, 4, 5]);
printLinkedList(head);

console.log("------------------------")
let newHead = reverseLinkedList(head);
printLinkedList(newHead)