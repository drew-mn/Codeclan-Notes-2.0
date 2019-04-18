const assert = require('assert');
const Room = require('../room.js');

describe('Room', function () {

  let room;

  beforeEach(function () {
    room = new Room(20);
  });

  it('should have an area in square meters', function () {
    const expected = 20;
    assert.strictEqual(expected, room.areaInSquareMeters);
  });

  it('should start not painted', function () {
    const expected = false;
    assert.strictEqual(expected, room.isPainted);
  });

  it('should be able to be painted', function () {
    room.paint();
    const expected = true;
    assert.strictEqual(expected, room.isPainted);
  });

});
