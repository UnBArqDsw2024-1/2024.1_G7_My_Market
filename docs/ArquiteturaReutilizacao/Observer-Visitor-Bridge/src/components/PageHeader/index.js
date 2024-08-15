import React, { memo } from "react";
import { Box, Flex, Heading } from "@chakra-ui/react";

const PageHeader = memo(({ title, subtitle, children }) => {
  return (
    <Flex justifyContent="space-between" marginBottom={8}>
      <Box>
        <Heading>{title}</Heading>
        {subtitle}
      </Box>

      <Box>{children}</Box>
    </Flex>
  );
});

PageHeader.displayName = "PageHeader";

export default PageHeader;