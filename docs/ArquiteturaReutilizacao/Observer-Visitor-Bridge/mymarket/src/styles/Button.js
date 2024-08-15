export const Button = {
  baseStyle: {},
  sizes: {},
  variants: {
    primary: {
      minWidth: "175px",
      color: "#F4F7F5",
      backgroundColor: "primary",
      backgroundImage:
        "linear-gradient(to right, #FF8008 0%, #FFA03A 51%, #FF8008 100%);",
      backgroundSize: "200% auto",
      boxShadow: "soft",
      transition: "0.5s",
      _hover: {
        backgroundPosition:
          "right center" /* change the direction of the change here */,
        textDecoration: "none",

        _disabled: {
          background: ""
        }
      }
    },
    secondary: {
      minWidth: "150px",
      color: "#F4F7F5",
      backgroundImage:
        "linear-gradient(to right, #000428 0%, #004e92  51%, #000428  100%)",
      backgroundSize: "200% auto",
      boxShadow: "soft",
      transition: "0.5s",
      _hover: {
        backgroundPosition:
          "right center" /* change the direction of the change here */,
        textDecoration: "none",

        _disabled: {
          background: ""
        }
      }
    },
    tertiary: {
      color: "#333",
      backgroundImage:
        "linear-gradient(to right, #E0EAFC 0%, #CFDEF3  51%, #E0EAFC  100%)",
      backgroundSize: "200% auto",
      boxShadow: "sm",
      transition: "0.5s",
      _hover: {
        backgroundPosition:
          "right center" /* change the direction of the change here */,
        textDecoration: "none",

        _disabled: {
          background: ""
        }
      }
    }
  },
  defaultProps: {
    size: "md",
    variant: "primary"
  }
}