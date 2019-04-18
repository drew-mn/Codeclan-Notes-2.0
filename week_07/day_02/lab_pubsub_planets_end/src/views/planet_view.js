const PubSub = require('../helpers/pub_sub')


const PlanetView = function(element){
  this.element = element
}

PlanetView.prototype.bindEvents = function () {
  PubSub.subscribe('SolarSystem:planet-ready', (evt) => {
    const planet = evt.detail
    this.renderPlanet(planet)
  })
};

PlanetView.prototype.renderPlanet = function (planet) {
  this.element.innerHTML = ""
  const header = document.createElement('h1')
  header.textContent = planet.name
  header.classList.add('planet-detail-element')
  this.element.appendChild(header)
  this.createPTag('Day', `${planet.day} Earth days`)
  this.createPTag('Orbit', `${planet.orbit} Earth days`)
  this.createPTag('Surface Area', `${planet.surfaceArea} Earths`)
  this.createPTag('Volume', `${planet.volume} Earths`)
  this.createPTag('Gravity', `${planet.gravity}g`)
  this.createPTag('Moons', `${planet.moons}`)
  this.createImg(planet)
};

PlanetView.prototype.createPTag = function (key, value) {
  const p = document.createElement('p')
  p.textContent = `${key}: ${value}`
  p.classList.add('planet-detail-element')
  this.element.appendChild(p)
};

PlanetView.prototype.createImg = function (planet) {
  const img = document.createElement('img')
  img.src = planet.image
  img.alt = planet.name
  img.classList.add('planet-detail-img')
  this.element.appendChild(img)
};



module.exports = PlanetView
