<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminHeader.jsp"%>
    <head>
      <link rel="stylesheet" href="https://pyscript.net/alpha/pyscript.css" />
      <script defer src="https://pyscript.net/alpha/pyscript.js"></script>
      <py-env>
        - numpy
        - pandas
        - matplotlib
        - seaborn
      </py-env>
    </head>

  <body>
  	<div class="chart_wrapper">
	  	<div id="plot"></div>
	    <div id="plot2"></div>
  	</div>
    <py-script>
import matplotlib.pyplot as plt
import numpy as np
import asyncio
from pyodide.http import pyfetch
import seaborn as sns
import json
import pandas as pd


member = await pyfetch(
  url="http://localhost:8080/withbooks/adminNoChart",
  method="POST",
  headers={"Content-Type": "application/json"},
  body=json.dumps({"email": "aa", "password": "bb"})
)



member_info = json.dumps(await member.json())



df=pd.read_json(member_info)
df.loc[df['Member_authority'] != df['Member_authority'], 'Member_authority'] = 'normal'

fig, ax = plt.subplots()


sns.countplot(x="Member_sex", hue="Member_authority", data=df,ax=ax)
pyscript.write('plot', fig)
sns.countplot(x="Member_authority", hue="Member_sex", data=df,ax=ax)
pyscript.write('plot2', fig)
    </py-script>
  </body>
<%@ include file="../adminFooter.jsp"%>
