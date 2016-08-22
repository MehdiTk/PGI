$(document)
		.ready(
				function() {

					Chart.defaults.global.animationEasing = 'easeInOutQuad',
					// Chart.defaults.global.animation = false;
					Chart.defaults.global.responsive = true;
					Chart.defaults.global.scaleOverride = true;
					Chart.defaults.global.scaleShowLabels = false;
					Chart.defaults.global.scaleSteps = 10;
					Chart.defaults.global.scaleStepWidth = 10;
					Chart.defaults.global.scaleStartValue = 0;
					Chart.defaults.global.tooltipFontFamily = 'Open Sans';
					Chart.defaults.global.tooltipFillColor = '#FFFFFF';
					Chart.defaults.global.tooltipFontColor = '#6E6E6E';
					Chart.defaults.global.tooltipCaretSize = 0;
					Chart.defaults.global.maintainAspectRatio = true;

					Chart.defaults.Line.scaleShowHorizontalLines = false;
					Chart.defaults.Line.scaleShowHorizontalLines = false;
					Chart.defaults.Line.scaleGridLineColor = '#55505C';
					Chart.defaults.Line.scaleLineColor = '#55505C';

					var chart = document.getElementById('chart').getContext(
							'2d'), gradient = chart.createLinearGradient(0, 0,
							0, 450);
					var cpu_data = "#{serverBean.cpu_data}";
					var cpu_date = "#{serverBean.cpu_date}";
					var data = [], labels = [];

					cpu_data.split(",").forEach(function(usage) {
						data.push(parseInt(usage));
					});
					cpu_date.split("#").forEach(function(usage) {
						labels.push(parseInt(usage));
					});

					var dData = function() {
						return $('#formid span').text();
					};

					var data = {
						labels : [ "dD 1", "dD 2", "dD 3", "dD 4", "dD 5",
								"dD 6", "dD 7", "dD 8", "dD 9", "dD 10" ],

						datasets : [ {
							label : 'Custom Label Name',
							fillColor : gradient,
							strokeColor : '#FC2525',
							pointColor : 'white',
							pointStrokeColor : 'rgba(220,220,220,1)',
							pointHighlightFill : '#fff',
							pointHighlightStroke : 'rgba(220,220,220,1)',
							data : data
						} ]
					};

					gradient.addColorStop(0, 'rgba(255, 0,0, 0.5)');
					gradient.addColorStop(0.5, 'rgba(255, 0, 0, 0.25)');
					gradient.addColorStop(1, 'rgba(255, 0, 0, 0)');

					var chart = new Chart(chart).Line(data);

					setInterval(function() {
						// alert(dData());
						chart.removeData();
						chart.addData([ dData() ], "CPU");

					}, 1000);

				});
