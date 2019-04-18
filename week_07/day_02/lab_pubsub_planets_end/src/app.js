const planetsData = require('./data/planets.js');
const SolarSystem = require('./models/solar_system.js');
const MenuView = require('./views/menu_view');
const PlanetView = require('./views/planet_view');

document.addEventListener('DOMContentLoaded', () => {
  const planetsDataModel = new SolarSystem(planetsData);
  planetsDataModel.bindEvents()

  const menu = document.querySelectorAll('li.planet-menu-item')
  const menuView = new MenuView(menu)
  menuView.bindEvents()

  const planetDiv = document.querySelector('.planet-details')
  const planetView = new PlanetView(planetDiv)
  planetView.bindEvents()
});
