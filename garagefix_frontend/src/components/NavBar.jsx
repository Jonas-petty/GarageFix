import styled from "styled-components"

import { LinkButton } from "../styles"

export default function NavBar() {

  const Nav = styled.nav`
    background-color: #545E75;
    padding: 1rem;

    display: flex;
    align-items: center;
    justify-content: space-between;
    h1 {
      color: #F7F7FF;
    }
  `

  const Container = styled.div`
    margin-left: auto;

    width: 40%;

    display: flex;
    align-items: center;
    justify-content: space-between;

  `

  return (
      <Nav>
        <h1>GaragemFix</h1>

        <Container>
          <LinkButton primary >Home</LinkButton>
          <LinkButton>Clients</LinkButton>
          <LinkButton>Repairs</LinkButton>
        </Container>
      </Nav>
  )
}