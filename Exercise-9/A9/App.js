import './App.css';
import Header from './Header'
import Footer from './Footer'
import Main from './Main'
import Register from './Register'
import Contact from './Contact'
import Commit from './Committee'
import Call from './Call'
import Dates from './Dates'
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom'

function App() {
  return (
    <Router>
      <div>
          <Header />
          <Switch>
            <Route path="/Committee" component={Commit} />
            <Route path="/Call for papers" component={Call} />
            <Route path="/Important Dates" component={Dates} />
            <Route path="/Register" component={Register} />
            <Route path="/Contact" component={Contact} />
            <Route path="/" component={Main} />
          </Switch>
          <Footer />
      </div>

    </Router>
  );
}

export default App;
