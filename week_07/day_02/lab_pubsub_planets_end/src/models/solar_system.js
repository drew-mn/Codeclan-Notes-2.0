const PubSub = require('../helpers/pub_sub')

const SolarSystem = function(planets) {
  this.planets = planets;
};

SolarSystem.prototype.bindEvents = function () {
  PubSub.subscribe('MenuView:item-clicked', (evt) => {
    const selectedPlanet = evt.detail
    const planet = this.find(selectedPlanet)
    PubSub.publish('SolarSystem:planet-ready', planet)
  })
};

SolarSystem.prototype.find = function (planet) {
  const foundPlanet = this.planets.find((currentPlanet) => {
    return currentPlanet.name === planet
  });
  return foundPlanet;
};

module.exports = SolarSystem;
