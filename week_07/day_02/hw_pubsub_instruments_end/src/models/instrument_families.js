const PubSub = require('../helpers/pub_sub.js')

const InstrumentFamilies = function(data) {
  this.data = data;
};

InstrumentFamilies.prototype.bindEvents = function () {
  PubSub.publish('InstrumentFamilies:data-ready', this.data)
  PubSub.subscribe('SelectView:family-selected', (event) => {
    this.getFamily(event.detail)
  })
};

InstrumentFamilies.prototype.getFamily = function(index) {
  const selectedFamily = this.data[index]
  PubSub.publish('InstrumentFamilies:family-selected', selectedFamily)
};

module.exports = InstrumentFamilies;
