const PubSub = require('../helpers/pub_sub.js')

const FamilyView = function(element){
  this.element = element
}

FamilyView.prototype.bindEvents = function () {
  PubSub.subscribe('InstrumentFamilies:family-selected', (event) => {
    this.renderDetails(event.detail)
  })
};

FamilyView.prototype.renderDetails = function (family) {
  this.element.innerHTML = '';

  const familyName = this.createElement('h2', family.name);
  this.element.appendChild(familyName);

  const familyDescription = this.createElement('p', family.description);
  this.element.appendChild(familyDescription);

  const instrumentListTitle = this.createElement('h3', 'Instruments include:');
  this.element.appendChild(instrumentListTitle);

  const instrumentList = this.createInstrumentList(family.instruments);
  this.element.appendChild(instrumentList);
};

FamilyView.prototype.createElement = function (elementType, text) {
  const element = document.createElement(elementType);
  element.textContent = text;
  return element;
};

FamilyView.prototype.createInstrumentList = function (instruments) {
  const list = document.createElement('ul');

  instruments.forEach((instrument) => {
    const listItem = document.createElement('li');
    listItem.textContent = instrument;
    list.appendChild(listItem);
  });

  return list;
};

module.exports = FamilyView
