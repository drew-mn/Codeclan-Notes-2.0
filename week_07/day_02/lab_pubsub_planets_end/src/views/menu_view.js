const PubSub = require('../helpers/pub_sub')

const MenuView = function(listItems) {
  this.listItems = listItems
}

MenuView.prototype.bindEvents = function () {
  this.listItems.forEach((item) => {
    item.addEventListener('click', (evt) => {
      const selectedPlanet = evt.target.id
      PubSub.publish('MenuView:item-clicked', selectedPlanet)
    })
  })
};



module.exports = MenuView
