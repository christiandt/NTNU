<?xml version='1.0'?>
<xsl:stylesheet
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:fn="http://www.w3.org/2005/xpath-functions"
		xmlns:xmi="http://www.omg.org/XMI"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:xhtml="http://www.w3.org/1999/xhtml"
		xmlns:jex="platform:/plugin/no.hal.jex/model/jex.ecore"
		exclude-result-prefixes="xsl xmi xsi xhtml jex"
		version="2.0">

	<xsl:output method="html" />

	<xsl:template match="/jex:Exercise">
		<html>
			<head>
				<xsl:call-template name="head.content" />
			</head>
			<body>
				<xsl:call-template name="body.content" />
			</body>
		</html>
	</xsl:template>

	<xsl:template name="head.content">
		<style type="text/css">
			<xsl:text>
				{font-size: 1.0em;}
				code.small {font-size: 1.0em;}
				dl {margin-top: 0.9em;}
				dt {margin-top: 0.9em;}
				h2 {margin-top: 1.5em;}
				h3 {margin-top: 1.5em;}
				p {margin-top: 1.1em;}
				dl {margin-left: 2em;}
			</xsl:text>
		</style>
		<title>
			Exercise
			<xsl:value-of select="@text" />
		</title>
	</xsl:template>

	<xsl:template name="body.content">
		<xsl:variable name="nr" select="@text" />
		<xsl:variable name="prefile" select="description/xhtml:div/text()" />

		<xsl:for-each select="document($prefile)/exercise">
			<xsl:call-template name="title.subject" />
			<xsl:call-template name="title.exercise">
				<xsl:with-param name="exercise-nr" select="$nr" />
			</xsl:call-template>
			<xsl:call-template name="title.deadline" />
			<hr />
			<xsl:call-template name="objective" />
			<xsl:call-template name="general-requirements" />
			<xsl:call-template name="recommended-reading" />

		</xsl:for-each>

		<hr/>

		<xsl:call-template name="overview" />
		<xsl:call-template name="toc" />
		<xsl:call-template name="requirements" />
	</xsl:template>

	<xsl:template name="overview">
		<h2>Overview</h2>
		<xsl:copy-of select="comment/xhtml:div"/>
	</xsl:template>

	<xsl:template name="toc">
		<h2>Exercise parts</h2>
		<ol>
			<xsl:for-each select="requirements[@xsi:type='jex:ExercisePart']">
				<li>
					<a>
						<xsl:attribute name="href" select="concat('#', @xmi:id)" />
						<xsl:value-of select="@text" />
						<xsl:if test="(descendant-or-self::*/@points)">
       						<xsl:text> (</xsl:text>
       						<xsl:value-of select="sum(descendant-or-self::*/@points)"/>
		       				<xsl:text> pt.)</xsl:text>
						</xsl:if>
					</a>
				</li>
			</xsl:for-each>
		</ol>
		<hr />
	</xsl:template>

	<xsl:template name="requirements">
		<xsl:for-each select="requirements[@xsi:type='jex:ExercisePart']">
			<xsl:call-template name="part">
				<xsl:with-param name="level" select="1"></xsl:with-param>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="part">
		<xsl:param name="level" required="yes" />
		<xsl:variable name="hlevel" select="$level + 1"></xsl:variable>
		<xsl:variable name="header" select="concat('h', $hlevel)"></xsl:variable>

		<xsl:variable name="part-number">
			<xsl:number format="1.1.1" level="multiple" count="requirements[@xsi:type='jex:ExercisePart']">
			</xsl:number>
		</xsl:variable>

		<xsl:element name="{$header}">
			<a>
				<xsl:attribute name="name">
					<xsl:value-of select="@xmi:id" />
				</xsl:attribute>
				<xsl:text>Part </xsl:text>
				<xsl:value-of select="$part-number" />
				<xsl:text>: </xsl:text>
				<xsl:value-of select="@text" />
				<xsl:if test="(descendant-or-self::*/@points)">
       				<xsl:text> (</xsl:text>
       				<xsl:value-of select="sum(descendant-or-self::*/@points)"/>
       				<xsl:text> pt.)</xsl:text>
				</xsl:if>
			</a>
			<a>
				<xsl:attribute name="name">
					<xsl:value-of select="description/xhtml:div/@id" />
				</xsl:attribute>
			</a>
		</xsl:element>

		<xsl:for-each select="./description/xhtml:div/node()">
			<xsl:copy-of select="." />
		</xsl:for-each>

		<xsl:for-each select="requirements[@xsi:type='jex:ExercisePart']">
			<xsl:call-template name="part">
				<xsl:with-param name="level" select="$hlevel"></xsl:with-param>
			</xsl:call-template>
		</xsl:for-each>

		<xsl:if test="fn:exists(requirements[@xsi:type='jex:JavaRequirement'])">
			<dl>
				<xsl:for-each select="requirements[@xsi:type='jex:JavaRequirement']">
					<xsl:call-template name="req" />
				</xsl:for-each>
			</dl>
		</xsl:if>

		<i><xsl:copy-of select="./comment/xhtml:div" /></i>
	</xsl:template>

	<xsl:template name="req">
		<xsl:choose>
			<xsl:when test="description!=''">
				<dt>
					<a>
						<xsl:attribute name="name">
							<xsl:value-of select="description/xhtml:div/@id" />
						</xsl:attribute>
					</a>
					<code>
						<xsl:value-of select="@text" />
					</code>
					<xsl:if test="(descendant-or-self::*/@points)">
				       <xsl:text> (</xsl:text>
				       <xsl:value-of select="sum(descendant-or-self::*/@points)"/>
				       <xsl:text> pt.)</xsl:text>
					</xsl:if>
				</dt>
				<dd>
					<a>
						<xsl:attribute name="name">
							<xsl:value-of select="description/xhtml:div/@id" />
						</xsl:attribute>
					</a>
					<xsl:for-each select="./description/xhtml:div/node()">
						<xsl:copy-of select="." />
					</xsl:for-each>
					<p/>
					<xsl:for-each select="./comment/xhtml:div/node()">
						<xsl:copy-of select="." />
					</xsl:for-each>
				</dd>
			</xsl:when>
		</xsl:choose>
		<xsl:if test="fn:exists(./requirements[@xsi:type='jex:JavaRequirement'])">
			<xsl:for-each select="./requirements[@xsi:type='jex:JavaRequirement']">
				<xsl:call-template name="req" />
			</xsl:for-each>
		</xsl:if>
	</xsl:template>

	<xsl:template name="title.subject">
		<h1><xsl:text>TDT4100, Spring 2010</xsl:text></h1>
	</xsl:template>

	<xsl:template name="title.exercise">
		<xsl:param name="exercise-nr" />

		<h2>
			<xsl:text>Exercise </xsl:text>
			<xsl:value-of select="$exercise-nr" />
			<xsl:text>: </xsl:text>
			<xsl:value-of select="@title" />
		</h2>
	</xsl:template>

	<xsl:template name="title.deadline">
		<h3>
			<xsl:text>Deadline </xsl:text>
			<xsl:value-of select="@deadline" />
			<xsl:if test="fn:lower-case(@compulsory)='yes'">
				<xsl:text> (mandatory exercise)</xsl:text>
			</xsl:if>
		</h3>
	</xsl:template>

	<xsl:template name="objective">
		<h3><xsl:text>The objective of this exercise is to:</xsl:text></h3>
		<ul>
			<xsl:for-each select="objectives/obj">
				<li><xsl:value-of select="." /></li>
			</xsl:for-each>
		</ul>
	</xsl:template>

	<xsl:template name="general-requirements">
		<h3><xsl:text>General requirements:</xsl:text></h3>
		<ul>
			<xsl:for-each select="requirements/req">
				<li>
					<xsl:value-of select="." />
				</li>
			</xsl:for-each>
		</ul>
	</xsl:template>

	<xsl:template name="recommended-reading">
		<h3><xsl:text>Recommended reading:</xsl:text></h3>
		<xsl:for-each select="reading/book">
			<h4><xsl:value-of select="@title" /></h4>
			<ul>
				<xsl:for-each select="chapter">
					<li>
						<xsl:value-of select="@nr" />
						<xsl:text>: </xsl:text>
						<xsl:value-of select="." />
					</li>
				</xsl:for-each>
			</ul>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
