function createNode(value) {
    return {
        value: value,
        next: null
    }
}

const createLinkedList = elements => {
    let head = createNode(elements[0]);
    let current = head;
    for (let i = 1; i < elements.length; i++) {
        current.next = createNode(elements[i]);
        current = current.next;
    }
    return head;
}

const printLinkedList = (node, str) => {
    if (node.next == null) {
        str += node.value;
        console.log(str);
        return;
    }
    str += (`${node.value} -> `);
    printLinkedList(node.next, str);
}

const reverseLinkedList = head => {
    let current = head;
    let prev = null;

    while (current != null) {
        let next = current.next;

        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}

let head = createLinkedList([1, 2, 3, 4, 5]);
printLinkedList(head, "");

let reversedHead = reverseLinkedList(head);
printLinkedList(reversedHead, "");
