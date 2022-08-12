package com.testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

//@RunWith(JUnitPlatform.class)
@Suite
@SelectPackages({"com.testcases"})
@IncludePackages({"com.testcases.demo"})
class AllTest {


}
