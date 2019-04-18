const data = require('./data/data.js')
const InstrumentFamilies = require('./models/instrument_families.js')
const SelectView = require('./views/select_view.js')
const FamilyView = require('./views/family_view.js')

document.addEventListener('DOMContentLoaded', () => {

  const select = document.querySelector('#instrument-families')
  const selectView = new SelectView(select)
  selectView.bindEvents()

  const detailsDiv = document.querySelector('#family-details')
  familyView = new FamilyView(detailsDiv)
  familyView.bindEvents()

  const instrumentFamilies = new InstrumentFamilies(data)
  instrumentFamilies.bindEvents()



});
