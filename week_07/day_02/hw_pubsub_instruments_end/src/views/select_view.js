const PubSub = require('../helpers/pub_sub.js')

const SelectView = function(element){
  this.element = element
}

SelectView.prototype.bindEvents = function () {
  PubSub.subscribe('InstrumentFamilies:data-ready', (event) => {
    const families = event.detail
    this.populateSelect(families)
  })

  this.element.addEventListener('change', (event) => {
    const selectedFamily = event.target.value
    PubSub.publish('SelectView:family-selected', selectedFamily)
  })
};

SelectView.prototype.populateSelect = function (families) {
  families.forEach((family, index) => {
    const option = document.createElement('option')
    option.textContent = family.name
    option.value = index
    this.element.appendChild(option)
  })
};

module.exports = SelectView;
