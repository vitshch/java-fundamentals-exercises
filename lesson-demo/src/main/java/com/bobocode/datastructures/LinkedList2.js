function createNode (value) {
    return {
        next: null,
        value: value
    }
}

function createLinkedList(elements) {
    let head = createNode(elements[0]);
    let current = head;
    for (let i = 1; i <elements.length; i++) {
        let newNode = createNode(elements[i]);
        current.next = newNode;
        current = newNode;
    }
    return head;
}

function printLinkedList(head) {
    let current = head;
    let output = "";
    while (current.next != null) {
        output += `${current.value} -> `;
        current = current.next;
    }
    output += current.value;
    console.log(output);
}

function reverseLinkedList(head) {
    let current = head.next;
    let prev = head;
    let newCurrent = null;

    while (current != null) {
        newCurrent = current.next;
        current.next = prev;
        prev = current;

        current = newCurrent;
    }
    head.next = null;
    return prev;
}

let head = createLinkedList([1, 2, 3, 4, 5]);
printLinkedList(head);

let newHead = reverseLinkedList(head);
printLinkedList(newHead);