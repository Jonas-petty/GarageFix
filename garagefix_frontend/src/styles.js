import styled, { createGlobalStyle,  css } from "styled-components";
import { Link } from "react-router-dom";

const GlobalStyle = createGlobalStyle`
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
`

  const LinkButton = styled(Link)`
    background-color: #F7F7FF;
    color: #C03221;

    text-align: center;

    width: 10rem;

    padding: 0.5rem;
    border-radius: 5px;

    text-decoration: none;
    font-size: 1.2rem;

    /* ${props => props.primary && css`
      background-color: #C03221;
      color: #F7F7FF;
    `} */
  `

export { GlobalStyle, LinkButton }