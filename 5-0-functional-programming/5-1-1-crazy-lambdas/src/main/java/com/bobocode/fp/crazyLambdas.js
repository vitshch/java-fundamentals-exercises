// @author Vitalii Shcherban

function logTest(value) {
    console.log("\t" + value);
}

function helloSupplier() {
    return () => "Hello";
}
console.log("helloSupplier");
logTest(helloSupplier()());

function isEmptyPredicate() {
    return str => typeof str == 'string' && str.length !== 0;
}
console.log("isEmptyPredicate");
logTest(isEmptyPredicate()("Test"));
logTest(isEmptyPredicate()(""));

function stringMultiplier() {
    return (str, count) => str.repeat(count);
}
console.log("stringMultiplier");
logTest(stringMultiplier()("Tesla", 5));

function toDollarStringFunction() {
    return price => "$" + price;
}
console.log("toDollarStringFunction");
logTest(toDollarStringFunction()(100));

function lengthInRangePredicate(min, max) {
    return str => typeof str == 'string' && str.length >= min && str.length < max;
}
console.log("lengthInRangePredicate");
logTest(lengthInRangePredicate(1, 10)("Ford"));
logTest(lengthInRangePredicate(1, 10)(""));
logTest(lengthInRangePredicate(1, 10)("Looooooooong String"));

function randomIntSupplier() {
    return () => Math.floor(Math.random() * 1000); //todo random value without bounds
}
console.log("randomIntSupplier");
logTest(randomIntSupplier()());

function boundedRandomIntSupplier() {
    return bound => Math.floor(Math.random() * bound);
}
console.log("boundedRandomIntSupplier");
logTest(boundedRandomIntSupplier()(100));

function intSquareOperation() {
    return side => side * side;
}
console.log("intSquareOperation");
logTest(intSquareOperation()(5));

function longSumOperation() {
    return (a, b) => a + b;
}
console.log("longSumOperation");
logTest(longSumOperation()(10, 20));

function stringToIntConverter() {
    return str => parseInt(str);
}
console.log("stringToIntConverter");
logTest(stringToIntConverter()("1234"));

function nMultiplyFunctionSupplier(n) {
    return () => number => n * number;
}
console.log("nMultiplyFunctionSupplier");
logTest(nMultiplyFunctionSupplier(10)()(10));

function composeWithTrimFunction() {
    return fn => str => fn(str.trim());
}
console.log("composeWithTrimFunction");
logTest(composeWithTrimFunction()( str => str.toUpperCase())("   trim this string   "));

class Thread {

    constructor(runnable) {
        this.runnable = runnable;
    }

    start() {
        logTest("Starting thread");
        logTest(this.runnable());
    }
}

function runningThreadSupplier(runnable) {
    return () => {
        let thread = new Thread(runnable);
        thread.start();
        return thread;
    }
}
console.log("runningThreadSupplier");
let threadObj = runningThreadSupplier(() => "I'm running")();
logTest(threadObj instanceof Thread);

function newThreadRunnableConsumer() {
    return runnable => new Thread(runnable).start();
}
console.log("newThreadRunnableConsumer");
newThreadRunnableConsumer()(() => "Hello");

function runnableToThreadSupplierFunction() {
    return runnable =>
        () => {
            let thread = new Thread(runnable);
            thread.start();
            return thread;
        };
}
console.log("runnableToThreadSupplierFunction");
let runnableToThreadSupplierFunc = runnableToThreadSupplierFunction()(() => "Here is runnable");
logTest(runnableToThreadSupplierFunc() instanceof Thread);

function functionToConditionalFunction() {
    return (intUnaryOperator, intPredicate) =>
        value => {
            if (intPredicate(value)) {
                return intUnaryOperator(value);
            }
            return value;
        };
}
console.log("functionToConditionalFunc");
let functionToConditionalResult = functionToConditionalFunction()(
    value => value + 100,
    val => val !== null && val > 100
)(110);
logTest(functionToConditionalResult);

function functionLoader() {
    return (map, fnName) => {
        if (map.has(fnName)) {
            return map.get(fnName);
        }
        return value => value;
    };
}
console.log("functionLoader");
let map = new Map();
map.set("functionOne", value => value + 10);
map.set("functionTwo", value => value - 10);
let functionLoaderOneResult = functionLoader()(map, "functionOne");
let functionLoaderTwoResult = functionLoader()(map, "functionTwo");
let functionLoaderNotExist = functionLoader()(map, "functionNotExist");
logTest(functionLoaderOneResult(200));
logTest(functionLoaderTwoResult(200));
logTest(functionLoaderNotExist(200));


function trickyWellDoneSupplier() {
    return () => () => () => "WELL DONE!";
}
console.log("trickyWellDoneSupplier");
logTest(trickyWellDoneSupplier()()()());