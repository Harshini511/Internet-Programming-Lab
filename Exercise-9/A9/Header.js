import './styles.css';
import logo from './conf.jfif'
import {Link} from 'react-router-dom'


function Header() {
  return (
    <div className="Header">
      <div class="headingbar">
        <img src={logo} alt="Logo" height="50px"/>
        <div class="headRight">
          <Link to='/'>
            <a>Home</a>
          </Link>
          <Link to='/Committee'>
            <a>Committee</a>
          </Link>
          <Link to='/Call for papers'>
            <a>Call for papers</a>
          </Link>
          <Link to='/Important Dates'>
            <a>Dates</a>
          </Link>
          <Link to='/Register'>
          <a>Registration</a>
          </Link>
          <Link to='/Contact'>
          <a>Contact</a>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default Header;
