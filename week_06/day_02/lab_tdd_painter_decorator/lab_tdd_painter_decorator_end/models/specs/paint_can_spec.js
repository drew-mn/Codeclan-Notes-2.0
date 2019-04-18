const assert = require('assert');
const PaintCan = require('../paint_can.js');

describe('Paint Can', function () {

  let paintCan;

  beforeEach(function () {
    paintCan = new PaintCan(10);
  });

  it('should have a number of litres of paint', function () {
    const expected = 10;
    assert.strictEqual(expected, paintCan.litresOfPaint);
  });

  it('should not start empty', function () {
    const expected = false;
    assert.strictEqual(expected, paintCan.isEmpty());
  });

  it('should be able to empty itself', function () {
    paintCan.empty();
    const expected = true;
    assert.strictEqual(expected, paintCan.isEmpty());
  });

});
